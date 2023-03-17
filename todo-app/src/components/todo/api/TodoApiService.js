
import { apiClientDomain } from "./ApiClient";



export const retrieveAllTodosForUsername
= (username) => apiClientDomain.get(`/users/${username}/todos`)

export const retreiveTodoApi
= (username,id) => apiClientDomain.get(`/users/${username}/todo/${id}`)

export const deleteTodoApi
= (username,id) => apiClientDomain.delete(`/users/${username}/todo/${id}`)

export const updateTodoApi =
(username,id,todo) => apiClientDomain.put(`/users/${username}/todo/${id}`,todo)

export const createTodoApi = 
(username,todo) => apiClientDomain.post(`/users/${username}/todo`,todo)