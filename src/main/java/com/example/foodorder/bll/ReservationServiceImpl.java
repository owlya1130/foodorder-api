package com.example.foodorder.bll;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.dao.ReservationDao;
import com.example.foodorder.entity.Code;
import com.example.foodorder.entity.Reservation;
import com.example.foodorder.util.DateHelper;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;

	@Autowired
	private ReservationTimeBlockService reservationTimeBlockService;

	@Override
	public List<Reservation> findAll(Date startDate, Date endDate) {
		Date startDateTime = DateHelper.atStartOfDay(startDate);
		Date endDateTime = endDate == null ? DateHelper.atEndOfDay(startDate) : DateHelper.atEndOfDay(endDate);
		return reservationDao.findAll(startDateTime, endDateTime, null);
	}

	@Transactional
	@Override
	public Reservation save(Reservation entity) {
		if (conflictCheck(entity)) {
			return null;
		} else {
			return reservationDao.save(entity);
		}
	}

	@Transactional
	@Override
	public Reservation update(Reservation entity) {
		if (conflictCheck(entity)) {
			return null;
		} else {
			return reservationDao.update(entity);
		}
	}

	@Transactional
	@Override
	public Reservation delete(int uid) {
		return reservationDao.delete(uid);
	}

	private boolean conflictCheck(Reservation entity) {

		boolean conflict = false;

		List<Code> resvTimeBlocks = reservationTimeBlockService.findAll();
		if (resvTimeBlocks.size() > 0) {
			Date startDateTime = DateHelper.atStartOfDay(entity.getTime());
			Date endDateTime = DateHelper.atEndOfDay(entity.getTime());
			List<Reservation> reservations = reservationDao.findAll(startDateTime, endDateTime, entity.getTableUid());

			long resvTimeBlock = TimeUnit.MINUTES.toMillis(Integer.parseInt(resvTimeBlocks.get(0).getName()) * 30);

			for (Reservation reservation : reservations) {

				if (entity.getUid() == reservation.getUid()) {
					continue;
				}

				long resvTimeDiff = entity.getTime().getTime() - reservation.getTime().getTime();
				if (resvTimeDiff < 0) {
					continue;
				}
				if (resvTimeDiff < resvTimeBlock) {
					conflict = true;
				}
			}
		} else {
			System.err.println("無預約時間區塊");
			conflict = true;
		}

		return conflict;
	}

}
