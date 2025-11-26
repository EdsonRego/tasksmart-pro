import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-login-page',
  imports: [CommonModule, FormsModule],
  template: `
    <div class="flex items-center justify-center h-full">
      <div class="w-full max-w-md bg-white rounded-xl shadow p-6">
        <h1 class="text-xl font-semibold mb-4 text-slate-800">
          Login
        </h1>
        <p class="text-sm text-slate-600 mb-6">
          Autenticação do TaskSmart Pro (Auth Flow).
        </p>

        <form class="space-y-4">
          <div>
            <label class="block text-sm mb-1 text-slate-700">E-mail</label>
            <input
              type="email"
              class="w-full border rounded-lg px-3 py-2 text-sm focus:outline-none focus:ring focus:ring-blue-200"
            />
          </div>
          <div>
            <label class="block text-sm mb-1 text-slate-700">Senha</label>
            <input
              type="password"
              class="w-full border rounded-lg px-3 py-2 text-sm focus:outline-none focus:ring focus:ring-blue-200"
            />
          </div>
          <button
            type="button"
            class="w-full mt-2 py-2 rounded-lg text-sm font-medium bg-[#0A6ED1] text-white hover:bg-[#0854A0]"
          >
            Entrar
          </button>
        </form>
      </div>
    </div>
  `,
})
export class LoginPageComponent {}
