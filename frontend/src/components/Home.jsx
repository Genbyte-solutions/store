export function Home({user , setUser}) {
    const handleLogout = ()=>{
        setUser([])
    }
    return(
        <div>
            <h1>Hola {user}</h1>
            <button onClick={handleLogout}>Salir</button>
        </div>
    )
}