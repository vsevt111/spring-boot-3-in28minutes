import './TodoApp.css'
import {BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import LoginComponent from './LoginComponent'
import LogoutComponent from './LogoutComponent'
import WelcomeComponent from './WelcomeComponent'
import ListTodosComponent from './ListTodosComponent'
import ErrorComponent from './ErrorComponent'
import AuthProvider, { Context } from './security/AuthProvider'
import TodoComponent from './TodoComponent'

function AuthenticationRoute({children}){
    const authContext = Context()
    if(authContext.isAuthenticated){
        return children
    }
    return <Navigate to="/"/>
}

export default function TodoApp(){
    return(
        <div>
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path="/" element={<LoginComponent/>}/>
                        <Route path="/login" element={<LoginComponent/>}/>
                        <Route path="/welcome/:username" element={
                            <AuthenticationRoute>
                            <WelcomeComponent/>
                            </AuthenticationRoute>
                        }/>
                        <Route path="/todos" element={
                            <AuthenticationRoute>
                        <ListTodosComponent/>
                        </AuthenticationRoute>
                        }/>

                        <Route path="/todo/:id" element={
                            <AuthenticationRoute>
                        <TodoComponent/>
                        </AuthenticationRoute>
                        }/>
                        <Route path="/logout" element={
                            <AuthenticationRoute>
                        <LogoutComponent/>
                        </AuthenticationRoute>
                        }/>
                        <Route path="*" element={<ErrorComponent/>}/>
                    </Routes>
                    {/* <FooterComponent/> */}
                </BrowserRouter>
            </AuthProvider>
            {/* <WelcomeComponent/> */}
            
        </div>
    )
}




