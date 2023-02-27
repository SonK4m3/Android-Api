package retrofit

import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}