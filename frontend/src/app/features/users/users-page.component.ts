import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-users-page',
  imports: [CommonModule],
  template: `
    <h1 class="text-2xl font-semibold mb-4 text-slate-800">
      Usuários
    </h1>
    <p class="text-sm text-slate-600 mb-4">
      Gestão de usuários (User Flow). Integração futura com user-service.
    </p>
  `,
})
export class UsersPageComponent {}
