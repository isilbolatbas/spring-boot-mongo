package com.isilbolatbas.covid.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isilbolatbas.covid.model.*;

@Repository
public interface BilgilerRepository extends MongoRepository<Bilgiler, String> {

	@Aggregation(pipeline = {
			"{$group: { _id: '', toplamVaka: {$sum: $vaka}, toplamTaburcu: {$sum: $taburcu}, toplamVefat: {$sum: $vefat}}}" })
	public List<Result> total();

	@Aggregation(pipeline = {
			"{$group: { _id: { $toUpper: $il }, toplamVaka: {$sum: $vaka}, toplamTaburcu: {$sum: $taburcu}, toplamVefat: {$sum: $vefat}}}" })
	public List<ResultByCity> totalByCity();

	/*
	 * @Aggregation(pipeline = {
	 * " {$match: { tarih: '10.04.2020' }},{$group: { _id: { $toUpper: $tarih }, toplamVaka: {$sum: $vaka}, toplamTaburcu: {$sum: $taburcu}, toplamVefat: {$sum: $vefat}}}"
	 * }) public ResultByTarih totalByTarih(@Param("_id") String tarih);
	 */

}
