package io.anishbajpai.starter.di.config

import okhttp3.Interceptor
import okhttp3.Response

private const val HEADER_AUTH_TOKEN = "token"
const val HEADER_KEY_NO_AUTH = "key_no_auth"

class AuthInterceptor : Interceptor {

  var authToken = ""

  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request()
    val requestBuilder = request.newBuilder()

    if (request.header(HEADER_KEY_NO_AUTH) == null) {
      // needs credentials
      if (authToken.isEmpty()) {
        throw RuntimeException("Session token should be defined: " + request.url())
      } else {
        requestBuilder.addHeader(HEADER_AUTH_TOKEN, authToken)
      }
    } else {
      requestBuilder.removeHeader(HEADER_KEY_NO_AUTH)
    }
    return chain.proceed(requestBuilder.build())
  }

}