const person = {
    name:"Ranga Karanam",
    address:{
        line1: 'Baker Street',
        city: 'London',
        country : 'UK',
    },
    profiles:['twitter','linkedin','instagram'],

    //function
    printProfile: () => {
        person.profiles.map(
            profile=>profile
        )
        // console.log(person.profiles[0])
    }
}

// function printProfile(){
//     console.log(person.profiles[0])
// }

export default function LearningJavaScript(){
    return(
        <>
        <div>{person.name}</div>
        <div>{person.address.line1}</div>
        <div>{person.profiles[0]}</div>
        <div>{person.printProfile()}</div>
        </>
    )
}