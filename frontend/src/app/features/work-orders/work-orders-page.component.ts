// src/app/features/work-orders/work-orders-page.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-work-orders-page',
  imports: [CommonModule],
  template: `
    <h1 class="text-2xl font-semibold mb-4 text-slate-800">
      Ordens de Serviço
    </h1>
    <p class="text-sm text-slate-600 mb-4">
      Integração futura com work-order-service (Fluxo 3).
    </p>
  `,
})
export class WorkOrdersPageComponent {}
