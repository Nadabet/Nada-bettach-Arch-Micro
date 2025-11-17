import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  template: `
    <div class="app-container">
      <header class="app-header">
        <h1>Microservices Invoice Management System</h1>
        <nav>
          <ul>
            <li><a href="#/customers">Customers</a></li>
            <li><a href="#/products">Products</a></li>
            <li><a href="#/bills">Bills</a></li>
          </ul>
        </nav>
      </header>
      <main>
        <router-outlet></router-outlet>
      </main>
    </div>
  `,
  styles: [`
    .app-container {
      font-family: Arial, sans-serif;
    }
    
    .app-header {
      background-color: #333;
      color: white;
      padding: 20px;
      text-align: center;
    }
    
    .app-header h1 {
      margin: 0 0 20px 0;
    }
    
    nav ul {
      list-style: none;
      padding: 0;
      display: flex;
      justify-content: center;
      gap: 20px;
    }
    
    nav a {
      color: white;
      text-decoration: none;
    }
    
    nav a:hover {
      text-decoration: underline;
    }
    
    main {
      padding: 20px;
    }
  `]
})
export class AppComponent {
  title = 'Microservices Client';
}

