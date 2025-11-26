// src/app/features/auth/forgot-password-page.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-forgot-password-page',
  imports: [CommonModule],
  template: `
    <h1 class="text-xl font-semibold mb-2 text-slate-800">
      Esqueci minha senha
    </h1>
    <p class="text-sm text-slate-600">
      Em breve, fluxo real de recuperação de senha.
    </p>
  `,
})
export class ForgotPasswordPageComponent {}
