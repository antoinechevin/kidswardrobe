import { useEffect, useState } from 'react'
import './App.css'

interface HealthResponse {
  status: string
  application: string
  timestamp: string
}

function App() {
  const [health, setHealth] = useState<HealthResponse | null>(null)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    fetch('/api/health')
      .then(res => res.json())
      .then(data => setHealth(data))
      .catch(err => setError(err.message))
  }, [])

  return (
    <div className="App">
      <h1>KidsWardrobe</h1>
      <div className="card">
        <h2>Application Status</h2>
        {health && (
          <div>
            <p>Status: <strong>{health.status}</strong></p>
            <p>Application: {health.application}</p>
            <p>Timestamp: {health.timestamp}</p>
          </div>
        )}
        {error && <p style={{ color: 'red' }}>Error: {error}</p>}
      </div>
      <p className="info">
        Walking skeleton ready. Start building features!
      </p>
    </div>
  )
}

export default App
