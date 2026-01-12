#!/bin/bash

echo "🚀 Setting up KidsWardrobe development environment..."

# Setup Claude Code and Happy permissions
mkdir -p ~/.claude
sudo chown -R vscode:vscode ~/.claude
chmod -R 755 ~/.claude

mkdir -p ~/.happy
sudo chown -R vscode:vscode ~/.happy
chmod -R 755 ~/.happy

# Install global npm tools
echo "📦 Installing global npm packages..."
npm install -g @anthropic-ai/claude-code || true
npm install -g happy-coder || true

# Backend setup
if [ -d "backend" ]; then
  echo "☕ Setting up backend dependencies..."
  cd backend
  ./mvnw dependency:go-offline || true
  cd ..
else
  echo "⏭️  Backend not yet created, skipping..."
fi

# Frontend setup
if [ -d "frontend" ]; then
  echo "⚛️  Setting up frontend dependencies..."
  cd frontend
  npm install || true
  cd ..
else
  echo "⏭️  Frontend not yet created, skipping..."
fi

# E2E setup
if [ -d "e2e" ]; then
  echo "🎭 Setting up E2E test dependencies..."
  cd e2e
  npm install || true
  npx playwright install chromium --with-deps || true
  cd ..
else
  echo "⏭️  E2E not yet created, skipping..."
fi

echo ""
echo "✅ Dev environment ready!"
