import {PropTypes} from 'prop-types'
export default function CounterButton({by, incrementMethod, decreaseMethod}){
    // const buttonStyle ={
    //     fontSize:"30pb",
    //     backgroundColor:"#00a5ab",
    //     width:"100px",
    //     margin:"10px",
    //     color:"white",
    //     padding:"15px",
    //     borderRadius:"30px"
    // }
    // return [0,f] currentValue, function to update state
    // const [count,setCount] = useState(0)
    // function incrementCounterFunction(){
    //     // setCount(count+by)
    //     incrementMethod(by)
    // }

    // function minusCounterFunction(){
    //     // setCount(count-by)
    //     decreaseMethod(by)
    // }

    return(
        <div className="Counter">
            {/* <span className="count">{count}</span> */}
            <div>
                <button className="counterButton" 
                onClick={()=>incrementMethod(by)}
                // style = {buttonStyle}
                >
                    +{by}
                </button>

                <button className="counterButton" 
                onClick={()=>decreaseMethod(by)}
                // style = {buttonStyle}
                >
                    -{by}
                </button>
            </div>
        </div>
    )
}

CounterButton.propTypes={
    by: PropTypes.number
}

CounterButton.defaultProps={
    by:9
}