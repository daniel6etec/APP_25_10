package com.example.app_25_10.repository;

import com.example.app_25_10.model.Cronos;

import java.util.List;
import java.util.concurrent.Flow;

import javax.inject.Inject;

import kotlinx.coroutines.Dispatchers;

public class CronosRepository @Inject constructor(private val CronosDatabseDao: cronosDatabaseDao) {

    suspend fun addCrono(crono: Cronos) = cronosDatabaseDao.insert(crono)
    suspend fun updateCrono(crono: Cronos) = cronosDatabaseDao.update(crono)
    suspend fun deleteCrono(crono: Cronos) = cronosDatabaseDao.delete(crono)
    fun getAllCronos():Flow<List<Cronos>> = cronosDatabaseDao.getCronos().flowOn(Dispatchers.IO).conflate()
    fun getCronoById(id:Long): Flow<Cronos> = cronosDatabaseDao.getCronosById(id).flowOn(Dispatchers.IO).conflate()
}
