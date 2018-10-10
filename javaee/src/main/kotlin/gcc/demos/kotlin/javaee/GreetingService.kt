/*******************************************************************************
 * (c) Copyright IBM Corporation 2017.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package gcc.demos.kotlin.javaee

import javax.ws.rs.core.Application
import javax.ws.rs.core.Response
import javax.ws.rs.Path
import javax.ws.rs.ApplicationPath
import javax.ws.rs.PathParam
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.core.MediaType

import gcc.demos.kotlin.javaee.Greeting

var greet = "Hello"

@Path("/greeting")
@ApplicationPath("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class GreetingService : Application() {

    /*
    companion object {
        var greet = "Hello"
    }
    */

    @GET
    @Path("/{name}")
    fun sayGreeting(@PathParam("name") name: String) =  Greeting("${greet}", name)

    @GET
    fun anonymous() =  Response.status(Response.Status.METHOD_NOT_ALLOWED)
                               .entity("Path parameter 'name' not found").build();

    @POST
    fun setGreeting(greeting: Greeting): Unit {
        greet = greeting.message
    }
}