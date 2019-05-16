package me.soshin.springdatademo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    /**
     * Results in:
     *    select
     *         customer0_.id as id1_0_,
     *         customer0_.email as email2_0_,
     *         customer0_.name as name3_0_
     *     from
     *         customer customer0_
     *     where
     *         customer0_.email like ? escape ?
     *     order by
     *         customer0_.id desc
     * binding parameter [1] as [VARCHAR] - [%gmail.com]
     * binding parameter [2] as [CHAR] - [\]
     */
    List<Customer> findAllByEmailEndsWithOrderByIdDesc(String email);

    /**
     * Results in:
     *     select
     *         customer0_.id as id1_0_,
     *         customer0_.email as email2_0_,
     *         customer0_.name as name3_0_
     *     from
     *         customer customer0_
     *     where
     *         upper(customer0_.name) like upper(?) escape ? limit ?
     * binding parameter [1] as [VARCHAR] - [%alex%]
     * binding parameter [2] as [CHAR] - [\]
     */
    List<Customer> findFirstByNameIgnoreCaseContaining(String name);
}