package com.sf.tinker

import com.sf.tinker.business.LoginBizImpl
import org.junit.Before
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginTest {
    @Before
    fun setUp() {
        //将rx异步转同步
    }

    @Test
    fun testLogin() {
        val result = LoginBizImpl().loginRequest("mls","123456")
        println("result = ${result}")
    }
}
