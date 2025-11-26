// src/app/features/analytics/analytics-dashboard-page.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-analytics-dashboard-page',
  imports: [CommonModule],
  template: `
    <h1 class="text-2xl font-semibold mb-4 text-slate-800">
      Dashboard / Analytics
    </h1>
    <p class="text-sm text-slate-600 mb-6">
      Painel principal de métricas (Fluxo 4).
    </p>

    <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
      <div class="bg-white rounded-xl shadow p-4">
        <h2 class="text-sm font-medium text-slate-700 mb-1">
          Ordens em aberto
        </h2>
        <p class="text-2xl font-bold text-slate-900">—</p>
      </div>

      <div class="bg-white rounded-xl shadow p-4">
        <h2 class="text-sm font-medium text-slate-700 mb-1">
          Notificações hoje
        </h2>
        <p class="text-2xl font-bold text-slate-900">—</p>
      </div>

      <div class="bg-white rounded-xl shadow p-4">
        <h2 class="text-sm font-medium text-slate-700 mb-1">
          Usuários ativos
        </h2>
        <p class="text-2xl font-bold text-slate-900">—</p>
      </div>
    </div>
  `,
})
export class AnalyticsDashboardPageComponent {}
