import { Creator } from 'src/app/courses/types/creator';

export interface Course {
  id: number;
  name: string;
  description: string;
  enabled: boolean;
  createdAt: Date;
  updatedAt: Date;
  creator: Creator;
}
