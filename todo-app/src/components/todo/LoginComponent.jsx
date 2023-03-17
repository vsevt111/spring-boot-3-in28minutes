import {useState} from 'react'
import {useNavigate} from 'react-router-dom'
import { Context } from './security/AuthProvider'
function LoginComponent(){

    const [username , setUsername] = useState('in28minutes')

    const [password, setPassword] = useState('')

    // const [showSuccessMessage , setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate()

    //have to be pascal case
    const AuthContext = Context()
    function handleUsernameChange(event){
        setUsername(event.target.value)
    }

    function handlePasswordChange(event){
        setPassword(event.target.value)
    }

    async function handleClick(){
        if(await AuthContext.login(username,password)){
            navigate(`/welcome/${username}`)
        }
        else{
            setShowErrorMessage(true)
        }
    }

    return(
        <div className="Login">
            <h1>Time to Login</h1>
            {/* <SuccessMessageComponent/>
            <ErrorMessageComponent/> */}
            {/* {showSuccessMessage && <div className="successMessage">Authenication Successfully</div>} */}
            {showErrorMessage && <div className="errorMessage">Authentication Failed. Please check your credential</div>}
            <div className="LoginForm"> 
                <label>Username</label>
                <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
            </div>
            <div>
                <button type="button" name="login" onClick={handleClick}>login</button>
            </div>
        </div>
    )
}

export default LoginComponent