import { apiClientDomain } from "./ApiClient";

export const executeBasicAuthentication 
= (token) => apiClientDomain.get(`/basicauth`
,{
    headers:{
        Authorization: token
    }
}
)

export const executeJwtAuthentication 
= (username,password) => apiClientDomain.post(`/authenticate`
,{username,password}
)