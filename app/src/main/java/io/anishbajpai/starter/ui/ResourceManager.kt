package io.anishbajpai.starter.ui

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import io.anishbajpai.starter.di.ScopeApplication
import javax.inject.Inject

@ScopeApplication
class ResourceManager @Inject constructor(val context: Context) {

  fun getText(@StringRes resId: Int): CharSequence {
    return context.getText(resId)
  }

  fun getTextArray(@ArrayRes resId: Int): Array<CharSequence> {
    return context.resources.getTextArray(resId)
  }

  fun getQuantityText(@PluralsRes resId: Int, quantity: Int): CharSequence {
    return context.resources.getQuantityText(resId, quantity)
  }

  fun getString(@StringRes resId: Int): String {
    return context.getString(resId)
  }

  fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
    return context.getString(resId, formatArgs)
  }

  fun getStringArray(@ArrayRes resId: Int): Array<String> {
    return context.resources.getStringArray(resId)
  }

  fun getQuantityString(@PluralsRes resId: Int, quantity: Int): String {
    return context.resources.getQuantityString(resId, quantity)
  }

  fun getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any): String {
    return context.resources.getQuantityString(resId, quantity, formatArgs)
  }

  fun getInteger(@IntegerRes resId: Int): Int {
    return context.resources.getInteger(resId)
  }

  fun getIntArray(@ArrayRes resId: Int): IntArray {
    return context.resources.getIntArray(resId)
  }
}