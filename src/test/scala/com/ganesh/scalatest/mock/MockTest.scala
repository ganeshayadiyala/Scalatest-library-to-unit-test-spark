package com.ganesh.scalatest.mock

import java.io.{File, FileWriter}

import org.mockito.Matchers._
import org.mockito.Mockito
import org.scalatest.{Failed, Matchers, Outcome, WordSpec}
import org.spark_project.jetty.security.LoginService

class MockTest extends WordSpec with Matchers {
  case class User(name: String)

  trait LoginService {
    def login(name: String, password: String): Option[User]
  }

  class RealLoginService extends LoginService {
    override def login(name: String, password: String): Option[User] = None
  }

  "test login service" in {
    val service = Mockito.mock(classOf[LoginService])

    Mockito.when(service.login("johndoe","secret")).thenReturn(Some(User("johndoe")))
    Mockito.when(service.login("joehacker", "secret")).thenReturn(None)

    val johndoe = service.login("johndoe", "secret")
    val joehacker = service.login("joehacker", "secret")

    assert(johndoe.get == User("johndoe"))
    assert(joehacker == None)
  }
}