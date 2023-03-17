import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { deleteTodoApi, retrieveAllTodosForUsername } from "./api/TodoApiService"
import { Context } from "./security/AuthProvider"

function ListTodosComponent(){
    // const today = new Date()
    // const targetDate = new Date(today.getFullYear()+12,today.getMonth(),today.getDay())
    // const todos = [{id:1,description:"Learn AWS",done:false,targetDate:targetDate},
    //             {id:2,description:"Learn Full Stack Developer",done:false,targetDate:targetDate},
    //             {id:3,description:"Learn DevOps",done:false,targetDate:targetDate}]

    //useEffect - tell react that your component have to do something after render
    useEffect(()=>refreshTodos(),[])

    const [todos,setTodo] = useState([])
    const [message,setMessage] = useState(null)
    const authContext = Context();
    const username = authContext.username
    const navigate = useNavigate()
    function refreshTodos(){
        retrieveAllTodosForUsername(username)
        .then((response)=>{setTodo(response.data)})
        .catch((error)=>console.log(error))
    }

    function deleteTodo(id){
        console.log("clicked delete")
        deleteTodoApi(username,id)
        .then(()=>{
            setMessage(`delete id = ${id} successfully`)
            refreshTodos()
        })
        .catch((error)=>console.log(error))
    }

    function updateTodo(id){
        console.log("clicked delete")
        navigate(`/todo/${id}`)
    }
    function addTodo(){
        navigate('/todo/-1')
    }
    return(
        <div className="container">
            <h1>Thing we want to do</h1>
            {message && 
            <div className="alert alert-warning">{message}</div>}
            <table className="table">

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Is Done?</th>
                        <th>Target Date</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    {
                    todos.map(todo=>(
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            {/* <td>{todo.targetDate.toDateString()}</td> */}
                            <td>{todo.targetDate.toString()}</td>
                            <td><button className="btn btn-warning" onClick={()=>deleteTodo(todo.id)}>Delete</button></td>
                            <td><button className="btn btn-success" onClick={()=>updateTodo(todo.id)}>Update</button></td>
                        </tr>
                    ))
                    }
                </tbody>
            </table>
            <button className="btn btn-success m-5"  onClick={addTodo}>Add Todo</button>
        </div>
    )
}

export default ListTodosComponent