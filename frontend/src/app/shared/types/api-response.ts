export interface ApiResponse<T> {
  content: ReadonlyArray<T>;
  totalPages: number;
  totalElements: number;
  last: boolean;
  first: boolean;
  number: number;
  numberOfElements: number;
  size: number;
  empty: boolean;
}
