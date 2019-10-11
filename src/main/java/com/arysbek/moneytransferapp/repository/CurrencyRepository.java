package com.arysbek.moneytransferapp.repository;

import com.arysbek.moneytransferapp.model.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
    //Custom query to find currency by Name
//    Iterable<Currency> findByCurrencyName(String currencyName);
}
