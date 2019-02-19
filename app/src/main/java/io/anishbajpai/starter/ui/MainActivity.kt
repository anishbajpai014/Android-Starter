package io.anishbajpai.starter.ui

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.anishbajpai.starter.R
import io.anishbajpai.starter.storage.DataRepository
import io.anishbajpai.starter.ui.base.BaseActivity
import io.anishbajpai.starter.ui.base.NavigationManager
import io.anishbajpai.starter.ui.base.createHomeFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

  lateinit var navigationManager: NavigationManager
  @Inject
  lateinit var dataRepository: DataRepository

  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
    setContentView(FrameLayout(this).apply { id = R.id.container })

    navigationManager = NavigationManager(supportFragmentManager, R.id.container)

    if (savedInstanceState == null) {
      navigationManager.openAsRoot(createHomeFragment())
    }
  }

  override fun supportFragmentInjector() = fragmentInjector
}