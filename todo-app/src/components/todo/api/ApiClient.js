import axios from "axios";

export const apiClientDomain = axios.create({
    baseURL:"http://localhost:8080"
})