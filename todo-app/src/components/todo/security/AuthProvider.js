import { createContext, useContext, useState } from "react";
import { apiClientDomain } from "../api/ApiClient";
import { executeJwtAuthentication } from "../api/AuthenticationApiService";
// import { executeBasicAuthentication } from "../api/HelloWorldApiService";

export const AuthContext = createContext()

//have to be pascal case
export const Context = ()=>useContext(AuthContext)

export default function AuthProvider({children}){
    // const [number,setNumber] = useState(10)
    const [isAuthenticated,setAuthenticated] = useState(false)
    const [username,setUsername] = useState(null)
    const [token,setToken] = useState(null)
    // function login(username, password){
    //     if(username === 'in28minutes' && password ==='dummy'){
    //         setAuthenticated(true)
    //         setUsername(username)
    //         return true
    //     }
    //     else{
    //         setAuthenticated(false)
    //         setUsername(null)
    //         return false
    //     }
        
    // }

    // async function login(username, password){
    //     //base64 encoding
    //     const baToken = "Basic "+window.btoa(username+":"+password)

    //     try{
    //     const response = await executeBasicAuthentication(baToken)
    //         if(response.status === 200){
    //         setAuthenticated(true)
    //         setUsername(username)
    //         setToken(baToken)

    //         apiClientDomain.interceptors.request.use((config)=>{
    //             console.log("intercept and add token")
    //             config.headers.Authorization=baToken
    //             return config
    //         })
    //         return true
    //     }
    //     else{
    //         logout()
    //         return false
    //     }
    // } catch(error){
    //     logout()
    //     return false
    // }
        
    // }

    async function login(username, password){
        //base64 encoding

        try{
        const response = await executeJwtAuthentication(username,password)
            
            if(response.status === 200){
                const jwtToken = 'Bearer '+response.data.token
            setAuthenticated(true)
            setUsername(username)
            setToken(jwtToken)

            apiClientDomain.interceptors.request.use((config)=>{
                console.log("intercept and add token "+jwtToken)
                config.headers.Authorization=jwtToken
                return config
            })
            return true
        }
        else{
            logout()
            return false
        }
    } catch(error){
        logout()
        return false
    }
        
    }

    function logout(){
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
    }
    // setInterval(()=>setNumber(number+1),10000)
    return(
        <AuthContext.Provider value={{isAuthenticated,login,logout,username,token}}>
            {children}
        </AuthContext.Provider>
    )
}