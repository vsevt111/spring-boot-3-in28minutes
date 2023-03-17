
import { useState } from 'react'
import {Link,useParams} from 'react-router-dom'
import {  retrieveHelloWorldPathVariable } from './api/HelloWorldApiService'
import { Context } from './security/AuthProvider'

function WelcomeComponent(){
    const {username} = useParams()
    const [message,setMessage] = useState(null)
    const authContext = Context()
    function callHelloWorldRestApi(){
        console.log('called')

        // axios.get('http://localhost:8080/hello-world')
        // .then((response)=>successfulResponse(response))
        // .catch((error)=>errorResponse(error))
        // .finally(console.log("clean up"))

        retrieveHelloWorldPathVariable(username,authContext.token)
        .then((response)=>successfulResponse(response))
        .catch((error)=>errorResponse(error))
        .finally(console.log("call to hello world bean successfully"))
    }

    // function callHelloWorldBeanRestApi(){
    //     axios.get("http://localhost:8080/hello-world-bean")
    //     .then((response)=>successfulResponse(response))
    //     .catch((error)=>errorResponse(error))
    //     .finally(console.log("call to hello world bean successfully"))
    // }
    
    function successfulResponse(response){
        console.log(response)
        //setMessage(response.data)
        setMessage(response.data.message)
    }

    function errorResponse(error){
        console.log(error)
    }
    return(
        <div className="welcomeComponent">
            <h1>Welcome {username}</h1>
            {/* List don't refresh entire page , refresh only modified component */}
            Manage your todos list - <Link to="/todos">Go Here!</Link>

            <div>
                <button className="btn btn-success" onClick={callHelloWorldRestApi}>Call Hello World</button>
                {/* <button className="btn btn-success" onClick={callHelloWorldRestApi}>Call Hello World Bean</button> */}
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}

export default WelcomeComponent