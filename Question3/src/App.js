import React, { useState } from "react";

function Counter(){
  const [count, setCount] = useState(0);

  const incrementOne = () =>{
    setCount(count + 1);
  }

  const resetCount = () =>{
    setCount(0);
  }

  return(
    <div>
      <center>
        <h1>Contador: {count}</h1>
        <button onClick={incrementOne}>Incrementar</button>
        <button onClick={resetCount}>Zerar</button>
      </center>
    </div>
  )
}

export default Counter;