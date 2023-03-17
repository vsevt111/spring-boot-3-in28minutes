import './Counter.css'
import {useState} from 'react'
import CounterButton from './CounterButton'

export default function Counter(){
    const [count,setCount] = useState(0)

    function incrementCounterParentFunction(by){
        setCount(count+by)
    }

    function minusCounterFunction(by){
        setCount(count-by)
    }

    function reset(){
        setCount(0)
    }
    return (
        <>
        <span className="totalCount">{count}</span>
        <CounterButton by={1} incrementMethod={incrementCounterParentFunction} decreaseMethod={minusCounterFunction}/>
        <CounterButton by={2} incrementMethod={incrementCounterParentFunction} decreaseMethod={minusCounterFunction}/>
        <CounterButton by={5} incrementMethod={incrementCounterParentFunction} decreaseMethod={minusCounterFunction}/>
        <button className="resetButton" onClick = {reset}>Reset</button>
        </>
    )
}
