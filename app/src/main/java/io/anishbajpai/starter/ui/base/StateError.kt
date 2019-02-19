package io.anishbajpai.starter.ui.base

sealed class StateError {
  object Recoverable : StateError()
  object NonRecoverable : StateError()
}