
import { apiClientDomain } from "./ApiClient";


export const retrieveHelloWorld = () => apiClientDomain.get("/hello-world-bean")

export const retrieveHelloWorldPathVariable 
= (username, token) => apiClientDomain.get(`/hello-world/path-variable/${username}`
// ,{
//     headers:{
//         Authorization: token
//     }
// }
)


// export const executeBasicAuthentication 
// = (token) => apiClientDomain.get(`/basicauth`
// ,{
//     headers:{
//         Authorization: token
//     }
// }
// )