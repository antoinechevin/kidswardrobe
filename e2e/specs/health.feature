Feature: Health Check
  En tant qu'administrateur système
  Je veux vérifier que l'application est en ligne
  Afin de m'assurer que tous les services fonctionnent

  Scenario: L'application est accessible
    Given je suis sur la page d'accueil
    Then je vois "KidsWardrobe"
    And le statut de l'application est "UP"
