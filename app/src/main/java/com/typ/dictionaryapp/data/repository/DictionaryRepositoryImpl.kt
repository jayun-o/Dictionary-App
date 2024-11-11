package com.typ.dictionaryapp.data.repository

import android.app.Application
import com.typ.dictionaryapp.R
import com.typ.dictionaryapp.data.api.DictionaryApi
import com.typ.dictionaryapp.data.mapper.toWordItem
import com.typ.dictionaryapp.domain.model.WordItem
import com.typ.dictionaryapp.domain.repository.DictionaryRepository
import com.typ.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
): DictionaryRepository{

    override suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: IOException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_t_get_result)))
                emit(Result.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow
                }
            }

            emit(Result.Error(application.getString(R.string.can_t_get_result)))
            emit(Result.Loading(true))
        }
    }
}