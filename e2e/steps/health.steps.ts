import { expect } from '@playwright/test';
import { createBdd } from 'playwright-bdd';
import { test } from './fixtures';

const { Given, Then } = createBdd(test);

Given('je suis sur la page d\'accueil', async ({ page }) => {
  await page.goto('/');
});

Then('je vois le statut {string}', async ({ page }, status: string) => {
  await expect(page.locator(`text=${status}`)).toBeVisible();
});
