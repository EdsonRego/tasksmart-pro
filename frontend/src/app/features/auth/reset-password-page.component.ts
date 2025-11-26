// src/app/features/auth/reset-password-page.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-reset-password-page',
  imports: [CommonModule],
  template: `
    <h1 class="text-xl font-semibold mb-2 text-slate-800">
      Redefinir senha
    </h1>
    <p class="text-sm text-slate-600">
      Em breve, fluxo real de redefinição usando token.
    </p>
  `,
})
export class ResetPasswordPageComponent {}
