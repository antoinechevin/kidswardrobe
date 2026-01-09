import { expect } from '@playwright/test';
import { Given, Then } from 'playwright-bdd/decorators';
import { test } from 'playwright-bdd';

export
@Given('je suis sur la page d\'accueil')
async function givenHomePage({ page }: { page: any }) {
  await page.goto('/');
}

export
@Then('je vois {string}')
async function thenISee({ page }: { page: any }, text: string) {
  await expect(page.getByText(text)).toBeVisible();
}

export
@Then('le statut de l\'application est {string}')
async function thenStatusIs({ page }: { page: any }, status: string) {
  await expect(page.getByText(`Status: ${status}`)).toBeVisible();
}
