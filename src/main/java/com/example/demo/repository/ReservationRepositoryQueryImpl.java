package com.example.demo.repository;

import com.example.demo.entity.QReservation;
import com.example.demo.entity.Reservation;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReservationRepositoryQueryImpl implements ReservationRepositoryQuery {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Reservation> search(Long userId, Long itemId) {
        return queryFactory
                .selectFrom(QReservation.reservation)
                .where(userIdEqual(userId), itemIdEqual(itemId))
                .fetch();
    }

    private BooleanExpression userIdEqual(Long userId) {
        return userId != null ? QReservation.reservation.user.id.eq(userId) : null;
    }

    private BooleanExpression itemIdEqual(Long itemId) {
        return itemId != null ? QReservation.reservation.item.id.eq(itemId) : null;
    }
}
