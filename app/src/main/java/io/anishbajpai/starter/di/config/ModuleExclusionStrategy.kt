package io.anishbajpai.starter.di.config

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.annotations.Expose

class NoModuleExclusionStrategy(private val allow: Boolean) : ExclusionStrategy {

  override fun shouldSkipClass(clazz: Class<*>): Boolean {
    return false
  }

  override fun shouldSkipField(field: FieldAttributes): Boolean {
    return !(
        field.getAnnotation(Expose::class.java) == null ||
            if (allow) field.getAnnotation(Expose::class.java).deserialize
            else field.getAnnotation(Expose::class.java).serialize)
  }

}