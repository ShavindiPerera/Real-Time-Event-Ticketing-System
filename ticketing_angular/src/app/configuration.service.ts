// src/app/services/config.service.ts
import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class ConfigurationService {
  private apiUrl = 'http://localhost:8081/api/v1/configuration/save-configuration'; // Your backend URL

  // Method to make POST request to add configuration
  async addConfiguration(configData: any) {
    try {
      const response = await axios.post(this.apiUrl, configData);
      return response.data; // Return the response to the component
    } catch (error) {
      console.error('Error adding configuration:', error);
      throw error;
    }
  }
}