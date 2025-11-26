import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-user-detail-page',
  imports: [CommonModule],
  template: `
    <h1 class="text-2xl font-semibold mb-4 text-slate-800">
      Detalhes do Usuário
    </h1>
    <p class="text-sm text-slate-600">
      Aqui virão os detalhes do usuário selecionado.
    </p>
  `,
})
export class UserDetailPageComponent {
  constructor(private route: ActivatedRoute) {
    // futura leitura de route.params
  }
}
