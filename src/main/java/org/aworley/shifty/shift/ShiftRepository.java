package org.aworley.shifty.shift;


import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by adam on 17/02/2017.
 */
public interface ShiftRepository extends PagingAndSortingRepository<Shift, Long> {
}
