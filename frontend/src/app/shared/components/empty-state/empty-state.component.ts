import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-empty-state',
  standalone: true,
  template: `
    <div class="text-center py-12 text-slate-500">
      <p class="text-sm">{{ message }}</p>
    </div>
  `,
})
export class EmptyStateComponent {
  @Input() message = 'Nenhum dado encontrado.';
}
