import { ErrorMessage, Field, Form, Formik } from "formik"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import { createTodoApi, retreiveTodoApi, updateTodoApi } from "./api/TodoApiService"
import { Context } from "./security/AuthProvider"

export default function TodoComponent(){

    const [description,setDescription] = useState('')
    const {id} = useParams()
    const authContext = Context()
    const username = authContext.username
    const [targetDate,setTargetDate] = useState('')

    const navigate = useNavigate()

    useEffect(()=>retrieveTodo(),[id])

    function retrieveTodo(){
        if (id !== -1) {
            retreiveTodoApi(username,id)
        .then((response)=>{
            setDescription(response.data.description)
            setTargetDate(response.data.targetDate)
        })
        .catch((error)=>console.log(error))
    }
    }

    function onSubmit(values){
        const todo={
            id:id,
            username:username,
            done:false,
            description:values.description,
            targetDate:values.targetDate
        }

        if (id!=-1)
        {updateTodoApi(username,id,todo)
        .then(()=>navigate('/todos'))
        .catch((error)=>console.log(error))
        console.log(values)}
        else{
            createTodoApi(username,todo)
            .then(response=>navigate('/todos'))
            .catch((error)=>console.log(error))
        }
    }

    function validate(values){

        let errors ={}
        if (values.description.length < 5){
            errors.description="Enter at least 5 character"
        }
        if (values.targetDate ==null){
            errors.targetDate = "Enter a valid target date"
        }
        console.log(values)
        return errors
    }

    

    return (
        <div className="container">
            <h1>Enter Todo Detail</h1>
            <div>
                {/* description:{description} */}
                {/* define function that return jsx 
                field tag = input tag*/}
                <Formik initialValues={{description,targetDate}}
                  enableReinitialize={true}
                  onSubmit={onSubmit}
                  validate={validate}
                //   only validate when click save button
                  validateOnChange={false}
                  validateOnBlur={false}>
                    {
                        (props)=>(
                            
                            <Form>
                                <ErrorMessage component="div" 
                                className="alert alert-warning" 
                                name="description"/>

                                <ErrorMessage component="div" 
                                className="alert alert-warning" 
                                name="targetDate"/>
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field  type="text" className="form-control" name="description"/>
                                </fieldset>

                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field  type="date" className="form-control" name="targetDate"/>
                                </fieldset>

                                <button className="btn btn-success m-5" type="submit">Save</button>
                            </Form>
                        )
                    }
                </Formik>
            </div>
            <div>
            
            </div>
        </div>
    )
}