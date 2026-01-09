import { useEffect, useState } from 'react'
import './App.css'

interface HealthResponse {
  status: string
  application: string
  timestamp: string
}

function App() {
  const [health, setHealth] = useState<HealthResponse | null>(null)
  const [error, setError] = useState<boolean>(false)

  useEffect(() => {
    fetch('/api/health')
      .then(res => {
        if (!res.ok) throw new Error('Failed to fetch')
        return res.json()
      })
      .then(data => setHealth(data))
      .catch(() => setError(true))
  }, [])

  return (
    <div className="App">
      <h1>KidsWardrobe</h1>
      <div className="card">
        {health && health.status === 'UP' && (
          <p style={{ fontSize: '1.5rem' }}>✅ Status: ok</p>
        )}
        {error && (
          <p style={{ fontSize: '1.5rem', color: '#ef4444' }}>❌ Erreur de connexion</p>
        )}
        {!health && !error && (
          <p style={{ fontSize: '1.5rem' }}>⏳ Chargement...</p>
        )}
      </div>
    </div>
  )
}

export default App
