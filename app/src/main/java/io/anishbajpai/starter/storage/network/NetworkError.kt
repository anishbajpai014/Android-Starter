package io.anishbajpai.starter.storage.network

sealed class ResponseType {

  companion object {
    fun identify(errorCode: Int): ResponseType {
      return when (errorCode / 100) {
        1 -> Informational
        2 -> Successful
        3 -> Redirection
        4 -> ClientError
        5 -> ServerError
        else -> Other
      }
    }
  }

  object Informational : ResponseType()
  object Successful : ResponseType()
  object Redirection : ResponseType()
  object ClientError : ResponseType()
  object ServerError : ResponseType()
  object Other : ResponseType()
}