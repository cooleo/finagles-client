package com.coole.finagle

import com.twitter.finagle.Http
import com.twitter.finagle.http.{RequestBuilder, Response}
import com.twitter.util.{Await, Future}

object BasicClient extends App {

  val client = Http.client.newService("0.0.0.0:7777")

  val request = RequestBuilder().url("http://0.0.0.0/").buildGet()
  val response: Future[Response] = client(request)

  Await.result {
    response.map(resp => println("\n\nRESPONSE: " + resp.contentString + "\n\n"))
  }

}
